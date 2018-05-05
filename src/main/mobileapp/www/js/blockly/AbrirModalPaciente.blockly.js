window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.AbrirModalPaciente = window.blockly.js.blockly.AbrirModalPaciente
		|| {};

/**
 * AbrirModalPaciente
 */
window.blockly.js.blockly.AbrirModalPaciente.abrir = function() {
	this.cronapi.screen.showModal("modalPaciente");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.AbrirModalPaciente.validador = function() {
	if (this.cronapi.screen.getValueOfField("vars.senha") == this.cronapi.screen
			.getValueOfField("vars.confirmar_senha")) {
		if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.screen
				.getValueOfField("vars.nome"))) {
			this.cronapi.util
					.callServerBlocklyNoReturn('blockly.PacienteEntidade:RetornaUsuarioInserido');
			this.cronapi.screen.changeValueOfField("user.password",
					this.cronapi.screen.getValueOfField("vars.senha"));
			this.cronapi.screen.changeValueOfField("user.username",
					this.cronapi.screen.getValueOfField("vars.email"));
			this.cronapi.myfunctions.chamarLogin("loginButton");
		} else {
			this.cronapi.screen.notify('success', 'O Nome é requerido');
		}
	} else {
		this.cronapi.screen.notify('success', 'Usuario e Senha Errado');
	}
}
