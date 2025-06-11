public class SQLFactory {
    public static void main(String[] args) {
        // Exemplo com Cliente
        System.out.println("\n=== CRUD CLIENTE ===");
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Agatha Fernandes Cunha");
        cliente.setEmail("Agatha@gmail.com");
        cliente.setTelefone("(66) 99999-9999");
        cliente.setEndereco("Avenida Vicente Risola, 1934");

        System.out.println("----------INSERT CLIENTE----------");
        System.out.println(cliente.insertSQL());
        Database.inserirRegistro(cliente);

        System.out.println("----------SELECT CLIENTE----------");
        Database.abrirID(cliente, 1);
        System.out.println("Novo cliente cadastrado: " + cliente.getNome());

        System.out.println("----------UPDATE CLIENTE----------");
        cliente.setNome("Ágatha Fernandes Cunha");
        System.out.println(cliente.updateSQL());
        Database.atualizarRegistro(cliente);

        Database.abrirID(cliente, 1);
        System.out.println("Cliente com novo nome corrigido: " + cliente.getNome());

        System.out.println("----------DELETE CLIENTE----------");
        System.out.println(cliente.deleteSQL());
        Database.deletarRegistro(cliente);
        System.out.println("Cliente não esta mais cadastrado: " + cliente.getId());

        // Exemplo com Fornecedor
        System.out.println("\n=== CRUD FORNECEDOR ===");
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(1);
        fornecedor.setNome("Empresa ABC");
        fornecedor.setCnpj("12.345.678/0001-90");
        fornecedor.setContato("Maria Santos");
        fornecedor.setEndereco("Av. Principal, 1000");

        System.out.println("----------INSERT FORNECEDOR----------");
        System.out.println(fornecedor.insertSQL());
        Database.inserirRegistro(fornecedor);

        System.out.println("----------SELECT FORNECEDOR----------");
        Database.abrirID(fornecedor, 1);
        System.out.println("Fornecedor adicionado: " + fornecedor.getNome());

        System.out.println("----------UPDATE FORNECEDOR----------");
        fornecedor.setNome("Empresa ABC Ltda");
        System.out.println(fornecedor.updateSQL());
        Database.atualizarRegistro(fornecedor);

        Database.abrirID(fornecedor, 1);
        System.out.println("Fornecedor atualizado: " + fornecedor.getNome());

        System.out.println("----------DELETE FORNECEDOR----------");
        System.out.println(fornecedor.deleteSQL());
        Database.deletarRegistro(fornecedor);
        System.out.println("Fornecedor deletado com sucesso: " + fornecedor.getId());
    }
}