window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalAgenteEstabelecimento = window.blockly.js.blockly.ModalAgenteEstabelecimento
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteEstabelecimento.fechar = function() {
	this.cronapi.screen.hideModal("modalAgenteE");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalAgenteEstabelecimento.exibir = function() {
	this.cronapi.screen.showModal("modalAgenteE");
}
