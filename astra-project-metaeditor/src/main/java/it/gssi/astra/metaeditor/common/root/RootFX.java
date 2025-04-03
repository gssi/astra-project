package it.gssi.astra.metaeditor.common.root;

import it.gssi.astra.metaeditor.common.property.CustomPropertySheetSkin;

public abstract class RootFX {
	
	public void populatePropertyView() {
		
		//per aggiornare il classname nella tab
		CustomPropertySheetSkin.getInstance().setTab1(null);
		
	}

}
