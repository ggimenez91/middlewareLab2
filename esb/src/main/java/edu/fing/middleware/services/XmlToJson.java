package edu.fing.middleware.services;

import org.json.JSONObject;
import org.json.XML;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class XmlToJson extends AbstractTransformer{

@Override
protected Object doTransform(Object src, String enc)
        throws TransformerException {
    JSONObject jsonObj = XML.toJSONObject((String) src);
            return  jsonObj.toString();
}
}