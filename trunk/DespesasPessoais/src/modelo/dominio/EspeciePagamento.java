/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dominio;

/**
 *
 * @author Marlon
 */
public class EspeciePagamento {

    private int id_especie_pagamento = 0 ;
    private String descricao         = "";
    private int operacao          =   0;
    private String tipo_conta        = "";

    public EspeciePagamento() {
    }

    /**
     * @return the id_especie_pagamento
     */
    public int getId_especie_pagamento() {
        return id_especie_pagamento;
    }

    /**
     * @param id_especie_pagamento the id_especie_pagamento to set
     */
    public void setId_especie_pagamento(int id_especie_pagamento) {
        this.id_especie_pagamento = id_especie_pagamento;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the operacao
     */
    public int getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the tipo_conta
     */
    public String getTipo_conta() {
        return tipo_conta;
    }

    /**
     * @param tipo_conta the tipo_conta to set
     */
    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    

}
