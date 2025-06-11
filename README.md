# OCR-SQLite-Manager

## 📋 Descrição
OCR-SQLite-Manager é um sistema de gerenciamento de dados que integra funcionalidades de OCR (Optical Character Recognition) com um banco de dados SQLite. O projeto implementa o padrão Factory para manipulação de registros, oferecendo uma interface robusta e flexível para operações CRUD (Create, Read, Update, Delete).

## 🚀 Funcionalidades
- Integração com banco de dados SQLite
- Implementação do padrão Factory para manipulação de dados
- Operações CRUD completas
- Classes modeladas com propriedades e métodos getters/setters
- Suporte a múltiplas entidades (Clientes, Fornecedores, Pedidos)

## 🛠️ Tecnologias Utilizadas
- Java
- SQLite
- JDBC (Java Database Connectivity)

## 📦 Estrutura do Projeto
```
OCR-SQLite-Manager/
├── db/
│   └── data.db
├── src/
│   ├── SQLFactory.java
│   ├── SQLClass.java
│   ├── Database.java
│   ├── Cliente.java
│   ├── Fornecedor.java
│   └── Pedido.java
└── README.md
```

## 🔧 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/OCR-SQLite-Manager.git
```

2. Certifique-se de ter o Java JDK instalado (versão 8 ou superior)

3. Adicione a dependência do SQLite JDBC ao seu projeto:
```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.8.11.2</version>
</dependency>
```

## 💻 Como Usar

### Exemplo de Uso com Cliente
```java
Cliente cliente = new Cliente();
cliente.setId(1);
cliente.setNome("Agatha Fernandes Cunha");
cliente.setEmail("Agatha@gmail.com");
cliente.setTelefone("(66) 99999-9999");
cliente.setEndereco("Avenida Vicente Risola, 1934");

// Inserir registro
Database.inserirRegistro(cliente);

// Consultar registro
Database.abrirID(cliente, 1);

// Atualizar registro
cliente.setNome("Ágatha Fernandes Cunha");
Database.atualizarRegistro(cliente);

// Deletar registro
Database.deletarRegistro(cliente);
```

### Exemplo de Uso com Fornecedor
```java
Fornecedor fornecedor = new Fornecedor();
fornecedor.setId(1);
fornecedor.setNome("Empresa ABC");
fornecedor.setCnpj("12.345.678/0001-90");
fornecedor.setContato("Maria Santos");
fornecedor.setEndereco("Av. Principal, 1000");

// Operações CRUD similares...
```

## 📝 Classes Principais

### SQLClass
Classe abstrata base que implementa as operações básicas de SQL:
- `selectSQL()`
- `insertSQL()`
- `updateSQL()`
- `deleteSQL()`

### Database
Classe responsável pela conexão e operações no banco de dados:
- `inserirRegistro()`
- `atualizarRegistro()`
- `deletarRegistro()`
- `abrirID()`

## 🤝 Contribuindo
1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Faça o Commit das suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Faça o Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## ✨ Autor
- catevildev - [@catevildev](https://github.com/catevildev)