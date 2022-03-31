<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Library Management</title>
  <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
</head>

<body>
  <jsp:include page='menu.jsp'></jsp:include>
  <main>
    <section class="content">
      <div class="page-announce valign-wrapper">
        <a href="#" data-activates="slide-out" class="button-collapse valign hide-on-large-only"><i class="material-icons">menu</i></a>
        <h1 class="page-announce-text valign">Liste des emprunts</h1>
      </div>
      <div class="row">
      <form action="/TP3Ensta/emprunt_list" method="get" class="col s12">
        <div class="container">
	        <div class="col s12">
	          <table class="striped">
                <thead>
                    <tr>
                        <th>Livre</th>
                        <th>Membre emprunteur</th>
                        <th>Date d'emprunt</th>
                        <th>Retour</th>
                    </tr>
                </thead>
                <tbody id="results">
                
                <tr>
                    <c:if test="${!borrowList.isEmpty()}">
            			<c:forEach items="${borrowList}" var="emprunt">
            			<tr>
                      <td>${emprunt.getLivre().getTitre()},${emprunt.getLivre().getAuteur()}</td>
                      <td>${emprunt.getMember().getNom()},${emprunt.getMember().getPrenom()}</td>
                      <td>${emprunt.getDateEmprunt()}</td>
                      
                      
                     <c:choose>
                     <c:when test="${emprunt.dateRetour != null}">
                      	<td>${emprunt.dateRetour}</td>
                      </c:when>
                      <c:otherwise>
                      	<td><a href="emprunt_return?id=${emprunt.id}">Retour</a></td>
                      </c:otherwise>
                      </c:choose>
                  	  
                		 </tr>
               			</c:forEach>
          			</c:if>
                        
   

                </tbody>
            </table>
          </div>
          </div>
          </form>
          </div>
        
     
    </section>
  </main>
  <jsp:include page='footer.jsp'></jsp:include>
</body>
</html>
