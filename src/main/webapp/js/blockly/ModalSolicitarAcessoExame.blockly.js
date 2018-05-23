window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalSolicitarAcessoExame = window.blockly.js.blockly.ModalSolicitarAcessoExame
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSolicitarAcessoExame.fechar = function() {

	var item, cpf;
	this.cronapi.screen.hideModal("modalNova");
}

/**
 * ModalSolicitarAcessoExame
 */
window.blockly.js.blockly.ModalSolicitarAcessoExame.solicitarAcesso = function(
		cpf) {

	var item, cpf;
	this.cronapi.util.callServerBlocklyNoReturn(
			'blockly.AutorizacaoAcessoExameWeb:solicitarAcesso', cpf);
	this.cronapi.screen.notify('success', 'Solicitação enviada');
	this.cronapi.screen.refreshDatasource("AutorizacaoAcessoExame", 'true');
	this.cronapi.screen.hideModal("modalNova");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalSolicitarAcessoExame.abrir = function() {

	var item, cpf;
	this.cronapi.screen.showModal("modalNova");
}
