import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;

public class Database {
    // Conexão com o banco de dados SQLite
    private static Connection connect() {
        // Garantir que o diretório db existe
        File dbDir = new File("db");
        if (!dbDir.exists()) {
            dbDir.mkdir();
        }

        String url = "jdbc:sqlite:db/data.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    // Metodo para executar um comando SQL
    public static boolean executeSQL(String sql) {
        boolean ok = false;
        
        Connection currentConnection = connect();
       
        try {
            Statement statement = currentConnection.createStatement();
            statement.execute(sql); // Executa o SQL passado como parâmetro
            currentConnection.close();
            ok = true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            ok = false;
        }

        return ok;
    }

    public static boolean inserirRegistro(SQLClass registro) {
        // Gera a string SQL com insertSQL() (ex: INSERT INTO produtos (...) VALUES (...))
        // Execute usando o método executeSQL(). Retorna true se deu certo, false se deu erro
        return executeSQL(registro.insertSQL());
    }

    // Atualiza um objeto no banco de dados usando seu ID
    public static boolean atualizarRegistro(SQLClass registro) {
        return executeSQL(registro.updateSQL());
    }

    // Deleta um registro do banco, também usando seu ID
    public static boolean deletarRegistro(SQLClass registro) {
        return executeSQL(registro.deleteSQL());
    }

    public static boolean abrirID(SQLClass registro, int id) {
        Field[] fields =  registro.getClass().getDeclaredFields();
        boolean ok = false;

        Connection currentConnection = connect();
        try {
            PreparedStatement stmt = currentConnection.prepareStatement(registro.selectSQL() + " where id = " + id);
            ResultSet resultSet = stmt.executeQuery();

            for (Field field : fields) {
                if (field.getType() == String.class) {
                    field.set(registro, resultSet.getString(field.getName()));
                } else {
                    field.set(registro, resultSet.getInt(field.getName()));
                }
            }

            ok = true;

            currentConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
            ok = false;
        }

        return ok;
    }

    public static boolean criarTabela(Class<?> classe) {
        try {
            // Criar uma instância da classe para obter o nome da tabela
            SQLClass instance = (SQLClass) classe.newInstance();
            String tableName = instance.getTableName();
            
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
            Field[] fields = classe.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldType = field.getType().getSimpleName();
                
                // Converter tipos Java para tipos SQLite
                if (fieldType.equals("String")) {
                    fieldType = "TEXT";
                } else if (fieldType.equals("int")) {
                    fieldType = "INTEGER";
                } else if (fieldType.equals("double")) {
                    fieldType = "REAL";
                }
                
                sql += field.getName() + " " + fieldType;
                
                // Adicionar vírgula se não for o último campo
                if (i < fields.length - 1) {
                    sql += ", ";
                }
            }
            sql += ")";
            
            System.out.println("Criando tabela: " + sql);
            return executeSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}