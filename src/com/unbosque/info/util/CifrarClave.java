package com.unbosque.info.util;

import java.io.Serializable;

import com.unbosque.info.util.GeneraClave;

public class CifrarClave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String cifradoClave(String claveTextoPlano) {
		String claveTextoCifrado = GeneraClave.getStringMessageDigest(
				claveTextoPlano, GeneraClave.MD5);

		return claveTextoCifrado;

	}
}
