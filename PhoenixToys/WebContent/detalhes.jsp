<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<h2 style="color:#00BFFF;text-shadow:#000 1px 1px 1px">Catálogo de brinquedos :: ${brinquedo.categoria} :: Brinquedo</h2>
<br>
<br>


<div class="col-md-4">
	<div class="thumbnail">
		<img src="imgProduto/${brinquedo.imagem}" class="thumbnail"
			width="400" height="400" />
	</div>
</div>
<div class="col-md-8">
	<p style="color:#D3D3D3;text-shadow:#000 1px 1px 1px">Cod: ${brinquedo.cod}</p>
	<h1 style="color:#4169E1;text-shadow:#000 1px 1px 1px">${brinquedo.descricao}</h1>
	<h3 style="color:#A9A9A9;text-shadow:#000 1px 1px 1px">R$${brinquedo.preco}</h3><br>
	<h4 style="color:#FFFFFF;text-shadow:#000 1px 1px 1px">${brinquedo.detalhes}</h4>
</div>



