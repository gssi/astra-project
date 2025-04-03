package it.gssi.astra.metaeditor.common.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Node;

public class FXMLeAttribute {
	
	private String ecoreAttributeName;

	private Map<Node, List<String>> fxmlNodes;
	
	public FXMLeAttribute(String ecoreAttributeName) {
		this.ecoreAttributeName = ecoreAttributeName;
		fxmlNodes = new HashMap<>();
	}
	
	public void addNodeProperty(Node node, String propertyName) {
		if (fxmlNodes.containsKey(node)) {
			List<String> list = fxmlNodes.get(node);
			list.add(propertyName);
		}
		else {
			List<String> list = new ArrayList<String>();
			list.add(propertyName);
			fxmlNodes.put(node, list);
		}
	}
	
	public String geteAttributeName() {
		return ecoreAttributeName;
	}
	
	public Map<Node, List<String>> getFXMLNodes() {
		return fxmlNodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ecoreAttributeName == null) ? 0 : ecoreAttributeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FXMLeAttribute other = (FXMLeAttribute) obj;
		if (ecoreAttributeName == null) {
			if (other.ecoreAttributeName != null)
				return false;
		} else if (!ecoreAttributeName.equals(other.ecoreAttributeName))
			return false;
		return true;
	}
}
