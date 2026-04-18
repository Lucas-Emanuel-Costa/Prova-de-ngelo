public class VendaProduto implements OperacaoEstoque {

    @Override
    public boolean processar(Produto produto, int quantidade) {
        if (produto == null) {
            return false;
        }

        if (quantidade <= 0) {
            return false;
        }

        if (quantidade > produto.getQuantidadeEmEstoque()) {
            return false;
        }

        produto.reduzirEstoque(quantidade);
        return true;
    }
}