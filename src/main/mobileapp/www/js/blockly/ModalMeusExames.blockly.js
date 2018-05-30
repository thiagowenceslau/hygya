window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalMeusExames = window.blockly.js.blockly.ModalMeusExames
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.fechar = function() {
	this.cronapi.screen.hideModal("modalExame");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalMeusExames.exibir = function() {
	this.cronapi.screen.showModal("modalExame");
}
