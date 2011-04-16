/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.antoniopassos.dukeclube.modelo.dominio;

import net.antoniopassos.dukeclube.excecao.DukeClubeException;

/**
 *
 * @author Marlon
 */
public class Socio {
    private Long codigo;
    private int categoria;
    private String nome;
    private int sexo;
    private java.util.Date dataNascimento;
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;

    public Socio() {        
    }
    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome (String nome) throws DukeClubeException {
       if (!this.isNomeValido(nome.trim())){
          throw new DukeClubeException("O nome do sócio deve ser informado!");
       }
       this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public int getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the dataNascimento
     */
    public java.util.Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(java.util.Date dataNascimento) throws DukeClubeException {
       
       if (!this.isMaiorDeIdade(dataNascimento)) {
          String mensagem = "Sócios devem ter 18 ou mais\nanos de idade!";
          throw new DukeClubeException(mensagem);
       }
       this.dataNascimento = dataNascimento;
    }

    /**
     * @return the telefoneFixo
     */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    /**
     * @param telefoneFixo the telefoneFixo to set
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    /**
     * @return the telefoneCelular
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * @param telefoneCelular the telefoneCelular to set
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private boolean isNomeValido(String nome){
      if (nome == null || nome.length() == 0) {
        return false;
      } else {
          return true;
        }
    }

    private boolean isMaiorDeIdade(java.util.Date dataDeNascimento) {
      long idadeEmAnos = this.calcularIdadeEmDias(dataDeNascimento) / 365;
      if (idadeEmAnos >= 18) {
          return true;
      } else {
           return false;
        }
    }

    private long calcularIdadeEmDias(java.util.Date dataDeNascimento){
      java.util.Date hoje = new java.util.Date();
      long idadeEmMilisegundos = hoje.getTime() - dataDeNascimento.getTime();
      long idadeEmDias = idadeEmMilisegundos / (1000 * 60 * 60 * 24);
      return idadeEmDias;
    }

}
