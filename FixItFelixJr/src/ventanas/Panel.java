package ventanas;

public class Panel {

	private EstadoPanel estado;

	// CREA UN PANEL CON LA PROBABILIDAD DE QUE ESTÉ ROTO O SANO
	public Panel(double Proba) {
		if ((0 < Proba) && (Proba < 0.3))
			this.setEstado(EstadoPanel.SANO);
		else if ((0.3 < Proba) && (Proba < 0.6))
			this.setEstado(EstadoPanel.SEMI_ROTO);
		else
			this.setEstado(EstadoPanel.ROTO);
	}

	// RETORNA EL ESTADO ACTUAL DEL PANEL
	public EstadoPanel getEstado() {
		return estado;
	}

	// CONFIGURA EL ESTADO DEL PANEL
	public void setEstado(EstadoPanel estado) {
		this.estado = estado;
	}

	// REPARA EL PANEL
	public void repararPanel() {
		if (estado.equals(EstadoPanel.ROTO)) {
			setEstado(EstadoPanel.SEMI_ROTO);
		} else {
			if (estado.equals(EstadoPanel.SEMI_ROTO)) {
				setEstado(EstadoPanel.SANO);
			}
		}
	}

}
