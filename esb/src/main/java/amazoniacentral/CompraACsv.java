package amazoniacentral;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;


public class CompraACsv extends AbstractTransformer {


	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		Compra c = (Compra) src;
	 //   System.out.println(new String("identificadorCompra,identificadorProducto,cantidad\n"+
	//			c.getIdCompra()+","+String.valueOf(c.getIdProducto())+","+String.valueOf(c.getCantidad())));
		
		return new String("identificadorCompra,identificadorProducto,cantidad\n"+
				c.getIdCompra()+","+String.valueOf(c.getIdProducto())+","+String.valueOf(c.getCantidad()));
	}

	
}

