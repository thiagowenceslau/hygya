window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalLogin = window.blockly.js.blockly.ModalLogin
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalLogin.exibirModalProfissional = function() {
	this.cronapi.screen.showModal("modalProfissional");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalLogin.fecharModalProfissional = function() {
	this.cronapi.screen.hideModal("modalProfissional");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalLogin.exibirModalPaciente = function() {
	this.cronapi.screen.showModal("modalPaciente");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalLogin.fecharModalPaciente = function() {
	this.cronapi.screen.hideModal("modalPaciente");
}
