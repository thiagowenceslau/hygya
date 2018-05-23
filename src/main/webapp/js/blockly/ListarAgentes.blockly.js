window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ListarAgentes = window.blockly.js.blockly.ListarAgentes
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ListarAgentes.exibir = function(dados) {

	var ativo, dados;
	ativo = this.cronapi.object.getProperty(dados, 'ativo');
	if (ativo != 'Sim') {
		this.cronapi.screen.disableComponent("crn-button-desativar");
		this.cronapi.screen.enableComponent("crn-button-ativar");
	}
	if (ativo == 'Sim') {
		this.cronapi.screen.disableComponent("crn-button-ativar");
		this.cronapi.screen.enableComponent("crn-button-desativar");
	}
	this.cronapi.screen.showModal("modalAgente");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ListarAgentes.esconder = function() {

	var ativo, dados;
	this.cronapi.screen.hideModal("modalAgente");
}
