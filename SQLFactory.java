public class SQLFactory {
    public static void main(String[] args) {
        // Criar tabelas
        Database.criarTabela(Cliente.class);
        Database.criarTabela(Fornecedor.class);
        Database.criarTabela(Pedido.class);

        // Se a tabela não existir, ela será criada
        Database.criarTabela(Cliente.class);
        Database.criarTabela(Fornecedor.class);
        Database.criarTabela(Pedido.class);

        // 1 Cliente
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


        // 2 Fornecedor
        System.out.println("\n=== CRUD FORNECEDOR ===");
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(1);
        fornecedor.setNome("M G Papelaria");
        fornecedor.setCnpj("04.576.775/0001-60");
        fornecedor.setContato("Laura Cavalcanti");
        fornecedor.setEndereco("Av. das Sibipirunas, 3411 - Centro, Sinop - MT");

        System.out.println("----------INSERT FORNECEDOR----------");
        System.out.println(fornecedor.insertSQL());
        Database.inserirRegistro(fornecedor);

        System.out.println("----------SELECT FORNECEDOR----------");
        Database.abrirID(fornecedor, 1);
        System.out.println("Fornecedor adicionado: " + fornecedor.getNome());

        System.out.println("----------UPDATE FORNECEDOR----------");
        fornecedor.setNome("MG Papelaria");
        System.out.println(fornecedor.updateSQL());
        Database.atualizarRegistro(fornecedor);

        Database.abrirID(fornecedor, 1);
        System.out.println("Fornecedor atualizado: " + fornecedor.getNome());

        System.out.println("----------DELETE FORNECEDOR----------");
        System.out.println(fornecedor.deleteSQL());
        Database.deletarRegistro(fornecedor);
        System.out.println("Fornecedor deletado com sucesso: " + fornecedor.getId());


        // 3 Pedido
        System.out.println("\n=== CRUD PEDIDO ===");
        Pedido pedido = new Pedido();
        pedido.setId(1);
        pedido.setClienteId(1);
        pedido.setFornecedorId(1);
        pedido.setQuantidade(10);
        pedido.setValor(100.0);

        System.out.println("----------INSERT PEDIDO----------");
        System.out.println(pedido.insertSQL());
        Database.inserirRegistro(pedido);

        System.out.println("----------SELECT PEDIDO----------");
        Database.abrirID(pedido, 1);
        System.out.println("Pedido adicionado: " + pedido.getId());

        System.out.println("----------UPDATE PEDIDO----------");
        pedido.setQuantidade(20);
        System.out.println(pedido.updateSQL());
        Database.atualizarRegistro(pedido);

        Database.abrirID(pedido, 1);
        System.out.println("Pedido atualizado: " + pedido.getId());

        System.out.println("----------DELETE PEDIDO----------");
        System.out.println(pedido.deleteSQL());
        Database.deletarRegistro(pedido);
        System.out.println("Pedido deletado com sucesso: " + pedido.getId());

    }
}