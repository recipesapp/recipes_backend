package org.chereshka.recipes.backend.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Photo implements Serializable {

	private static final long serialVersionUID = -8938059946425550877L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String MimeType;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] imageFile;
}
