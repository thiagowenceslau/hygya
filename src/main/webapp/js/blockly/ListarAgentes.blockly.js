window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ListarAgentes = window.blockly.js.blockly.ListarAgentes
		|| {};

var item, ativo;

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ListarAgentes.exibir = function() {
	ativo = this.cronapi.screen.getValueOfField("Agente.active.ativo");
	if (ativo == 'Sim') {
		this.cronapi.screen.disableComponent("crn-button-ativar");
	} else {
		this.cronapi.screen.enableComponent("crn-button-ativar");
	}
	if (ativo != 'Sim') {
		this.cronapi.screen.disableComponent("crn-button-desativar");
	} else {
		this.cronapi.screen.enableComponent("crn-button-desativar");
	}
	this.cronapi.screen.showModal("modalAgentes");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ListarAgentes.esconder = function() {
	this.cronapi.screen.hideModal("modalAgentes");
}
