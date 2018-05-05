window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PesquisarPaciente = window.blockly.js.blockly.PesquisarPaciente
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PesquisarPaciente.exibirModal = function() {
	this.cronapi.util
			.callServerBlocklyNoReturn('blockly.AtivarPaciente:validar');
	if (this.cronapi.screen.getValueOfField("Paciente.active.ativo") == true) {
		this.cronapi.screen.hideComponent("crn-button-ativar");
	}
	this.cronapi.screen.showModal("modalPesquisarPaciente");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PesquisarPaciente.esconderModal = function() {
	this.cronapi.screen.hideModal("modalPesquisarPaciente");
}
