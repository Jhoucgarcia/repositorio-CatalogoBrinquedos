<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<br><br>

	
	
	<c:forEach var="brinquedo" items="${brinquedos}">

	 

		<div class="col-sm-6 col-md-4">
			<a href="loja?action=detalhes&cod=${brinquedo.cod}" class="thumbnail">
				<img src="imgProduto/${brinquedo.imagem}" width="150" height="200" alt="...">
			</a>
			<div class="caption">
				<h3 class="text-center" style="color:#1E90FF;">${brinquedo.descricao}</h3>
				<p class="text-center" style="color:#778899;"><b>R$${brinquedo.preco}</b></p>
			</div>
		</div>

	

	</c:forEach>
</div>