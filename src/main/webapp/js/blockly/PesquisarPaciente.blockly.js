window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.PesquisarPaciente = window.blockly.js.blockly.PesquisarPaciente
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PesquisarPaciente.exibirModal = function(dados) {

	var item, ativo, dados;
	ativo = this.cronapi.object.getProperty(dados, 'ativo');
	if (ativo == 'Sim') {
		this.cronapi.screen.hideComponent("ativar");
	} else {
		this.cronapi.screen.showComponent("ativar");
	}
	this.cronapi.screen.showModal("modalPesquisarPaciente");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.PesquisarPaciente.esconderModal = function() {

	var item, ativo, dados;
	this.cronapi.screen.hideModal("modalPesquisarPaciente");
}
