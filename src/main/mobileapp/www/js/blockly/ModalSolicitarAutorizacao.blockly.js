window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalSolicitarAutorizacao = window.blockly.js.blockly.ModalSolicitarAutorizacao
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSolicitarAutorizacao.exibir = function() {

	var cpf;
	this.cronapi.screen.showModal("modal238");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSolicitarAutorizacao.fechar = function() {

	var cpf;
	this.cronapi.screen.changeValueOfField("vars.busca", '');
	this.cronapi.screen.hideModal("modal238");
}

/**
 * ModalSolicitarAutorizacao
 */
window.blockly.js.blockly.ModalSolicitarAutorizacao.solicitarAutorizacao = function(
		cpf) {

	var cpf;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.AutorizacaoAcessoExame:inserir', cpf);
	this.cronapi.screen.notify('success', 'Solicitação recebida');
	this.cronapi.screen.hideModal("modal238");
}
