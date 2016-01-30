package view;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import estereotipos.NamedBean;
import eventos.anotacoes.Contratacao;
import eventos.anotacoes.DesligamentoAnnotationLiteral;
import eventos.enums.TipoDesligamento;
import model.Funcionario;

@NamedBean
@ViewScoped
public class AppMB implements Serializable {

	private static final long serialVersionUID = -1575036985258916744L;

	private List<Funcionario> funcionarios;

	private Funcionario funcionario;

	/**
	 * No CDI é possivel disparar e escutar eventos sincronos ou assincronos.
	 * Para isso, basta injetar uma instancia de Event. É possivel utilizar
	 * qualificadores para restringir e selecionar os ouvintes do evento. Desta
	 * forma, é possivel ter um baixo acoplamento entre as classes.
	 */
	@Inject
	@Contratacao
	private Event<Funcionario> contratacaoEvent;

	@Inject
	private Event<Funcionario> desligamentoEvent;

	@PostConstruct
	protected void init() {
		this.funcionarios = new ArrayList<>();
		this.funcionario = new Funcionario();
	}

	public void contrataFuncionario() {
		this.funcionario.setId((long) new Random().nextInt(100));
		this.funcionarios.add(this.funcionario);
		
		/*
		 * Disparo do evento de contratacao
		 */
		this.contratacaoEvent.fire(this.funcionario);

		this.funcionario = new Funcionario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionário contratado com sucesso!"));
	}

	public void demiteFuncionario(Funcionario funcionario, TipoDesligamento tipoDesligamento) {
		this.funcionarios.remove(funcionario);

		/*
		 * Selecao do tipo de desligamento
		 */
		Annotation q = new DesligamentoAnnotationLiteral(tipoDesligamento);

		/*
		 * Disparo do evento de desligamento de acordo com o qualificador
		 * selecionado
		 */
		this.desligamentoEvent.select(q).fire(funcionario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionário desligado com sucesso!"));
	}

	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

}
