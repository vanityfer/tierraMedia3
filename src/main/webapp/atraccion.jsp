<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

<style>
* { font-family: 'MedievalSharp', cursive; 
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.titulo {
width:100%;
}

</style>




   
</head>

<body>


<html lang="es">

  
   
    
<body>
    <div class="container-fluid px-0">
        <nav class="navbar navbar-expand-lg navbar-light bg-dark">
            <div class="navbar-brand d-flex align-items-center">
                <a class="nav-link position-absolute start-45" href="#"><img src="img/logo-tierra-media.png" width="150" height="150"></a>
            </div>
            <div class="d-flex">
                <button class="navbar-toggler justify-content-start" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

              <div class="navbar-nav ms-auto barraIcons align-items-right"> 
             
                   <!--<a href="http://twitter.com/vanityfer"><span class="bi bi-twitter"></span></a>
                    <a href="https://www.facebook.com/fernanda.mugica/"><span class="bi bi-facebook"></span></a>
                    <a href="https://www.instagram.com/vanity.fer/?hl=fr"><span class="bi bi-instagram"></span></a>-->
                    <a class="nav-item nav-link" href="#"><span class="bi-facebook" alt="" width="30" height="24"></a>
                    <a class="nav-item nav-link " href="#"><span class="bi-instagram" alt="" width="30" height="24"></a>
                    <a class="nav-item nav-link " href="#"><span class="bi-twitter" alt="" width="30" height="24"></a>
                </div>

                
            </div>
        </nav>
    
       <nav class="navbar navbar-expand-lg navbar-light bg-light d-flex">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="navbar-nav w-100 justify-content-evenly">
                    <a class="nav-item nav-link active" href="index.jsp">Inicio</a>
                    <a class="nav-item nav-link" href="covid.jsp">Protocolo covid-19</a>
                    
                    <a class="nav-item nav-link" href="#">Contacto</a>
                    <a class="nav-item nav-link" href="loginUsuario.jsp">Login</a>
                </div>
            </div>
        </nav>

<main id="main">

  <script type="text/javascript">
    function main() {
      let ids = {
        'moria': '-FuA0guJKIE',
        'minas_tirith': 'RsGU8G9Y4Xc',
        'la_comarca': 'v1Am21sYIg4',
        'mordor': 'ofBcx9NPKRc',
        'abismo_de_helm': '_Q9qa4znv_E',
        'lothlorien': 'E-hTpE8WltU',
        'erebor': '1kxTo6w79qo',
        'bosque_negro': '3RzTrLV560w',
       
      };
      let titulos = {
        'moria': 'Moria',
        'minas_tirith': 'Minas Tirith',
        'la_comarca': 'La Comarca',
        'mordor': 'Mordor',
        'abismo_de_helm': 'Abismo de Helm',
        'lothlorien': 'Lothorien',
        'erebor': 'Erebor',
        'bosque_negro': 'Bosque Negro',
      };

      let costos = {
        'moria': '10',
        'minas_tirith': '5',
        'la_comarca': '3',
        'mordor': '25',
        'abismo_de_helm': '5',
        'lothlorien': '35',
        'erebor': '12',
        'bosque_negro': '3',

      };

      let duraciones = {
        'moria': '2',
        'minas_tirith': '2.5',
        'la_comarca': '6.5',
        'mordor': '3',
        'abismo_de_helm': '2',
        'lothlorien': '1',
        'erebor': '3',
        'bosque_negro': '4',

      };

      let cupos = {
        'moria': '6',
        'minas_tirith': '25',
        'la_comarca': '150',
        'mordor': '4',
        'abismo_de_helm': '15',
        'lothlorien': '30',
        'erebor': '32',
        'bosque_negro': '12',

      };

      let tipos = {
        'moria': 'Aventura',
        'minas_tirith': 'Paisaje',
        'la_comarca': 'Degustación',
        'mordor': 'Aventura',
        'abismo_de_helm': 'Paisaje',
        'lothlorien': 'Degustación',
        'erebor': 'Paisaje',
        'bosque_negro': 'Aventura',

      };
      


      let descripciones = {
        'moria': 'No importa dónde usted se encuentre, en Tierra Media siempre será testigo de la salida de un imponente Frodo Bolsón de la montaña, protagonizada por una figura de 18 metros de altura y 36 movimientos mecánicos. La música, los efectos especiales y la mirada de Frodo dando saltos a los cuatro costados, crean la atmósfera ideal para vivir otro momento mágico dentro de Tierra Media.',
        'minas_tirith': 'Para muchos es la atracción más emotiva de Tierra Media. Se destaca por su notable ambientación, en la cual un Frodo increíblemente real, sentado a la mesa junto a sus compañeros de aventuras, nos relata sus aventuras. Este espectáculo de luz, sonido y movimiento se convierte en un momento de recogimiento y espiritualidad para todos los visitantes.',
        'la_comarca': 'Tierra Media tiene el orgullo de contar entre sus atracciones con el hobbit animado más grande del mundo, que tiene la altura de 400 personas. Esta notable atracción está acompañada además con cientos de figuras de tamaño real y el más peculiar espectáculo de luz y sonido. Sin dudas, es una de las preferidas de las familias que visitan Tierra Media',
        'mordor': 'Tierra Media ofrece diariamente al visitante un completo programa de espectáculo musicales de primer nivel, con más de 20 bailarines en escena, más todo el brillo y el color característico de las danzas étnicas. Destacados artistas protagonizan la música y la danza de El señor de los anillos. Una opción cultural, colorida y sumamente entretenida para disfrutar en familia.',
        'abismo_de_helm': 'Magnífico espectáculo de imágenes, luz y sonido, basado en una libre interpretación del pasaje de Tolkien que describe el origen de la vida en la Tierra. La luz, el cielo, la tierra, el agua y todos los seres vivientes que poblaron el universo desde sus comienzos, son parte de esta increíble atracción .',
        'lothlorien': '«Tres Anillos para los Reyes Elfos bajo el cielo. Siete para los Señores Enanos en casas de piedra. Nueve para los Hombres Mortales condenados a morir. Uno para el Señor Oscuro, sobre el trono oscuro en la Tierra de Mordor donde se extienden las Sombras. Un Anillo para gobernarlos a todos. Un Anillo para encontrarlos, un Anillo para atraerlos a todos y atarlos en las tinieblas en la Tierra de Mordor donde se extienden las Sombras».',
        'erebor': 'Antes de partir, imposible volver a casa sin llevarse un recuerdo hecho por nuestros artesanos dentro del Parque. Las innumerables tiendas y negocios ofrecen a los visitantes originales productos de merchandising: imágenes religiosas, cruces, postales, adornos, jarros, vestimentas típicas y muchos recuerdos más. Para que usted no olvide las vivencias de un día único.',
        'bosque_negro': 'Los ferrocarriles de los parques de atracciones han tenido una larga y variada historia en los parques de atracciones estadounidenses así como en ultramar. Algunos de los primeros trenes de los parques no eran realmente trenes, sino tranvías, que traían a los clientes a los parques en líneas de ferrocarril regulares desde las ciudades hasta el final de las líneas del ferrocarril donde estaban ubicados los parques.',
        
      };

      
      let partes = window.location.href.split('?');
      let cod = partes[1].substring(2, partes[1].length);
    
      let pantalla = document.getElementById('pantalla');
      pantalla.src = 'https://www.youtube.com/embed/' + ids[cod];
    
      let titulo = document.getElementById('titulo');
      let descripcion = document.getElementById('descripcion');
      let costo = document.getElementById('costo');
      let duracion = document.getElementById('duracion');
      let cupo = document.getElementById('cupo');
      
      
      while (titulo.firstChild) {
        titulo.removeChild(titulo.firstChild);
      }
      titulo.appendChild(document.createTextNode(titulos[cod]));

     
      while (descripcion.firstChild) {
        descripcion.removeChild(descripcion.firstChild);
      }
      descripcion.appendChild(document.createTextNode(descripciones[cod]));

      while (costo.firstChild) {
        costo.removeChild(costo.firstChild);
      }
      costo.appendChild(document.createTextNode(costos[cod]));

      while (duracion.firstChild) {
        duracion.removeChild(duracion.firstChild);
      }
      duracion.appendChild(document.createTextNode(duraciones[cod]));

      while (cupo.firstChild) {
        cupo.removeChild(cupo.firstChild);
      }
      cupo.appendChild(document.createTextNode(cupos[cod]));
      
    }
      
    </script>
    
    <body onload="main()">
    
      <div class="collapse navbar-collapse custom-navmenu" id="main-navbar">
        <div class="container py-2 py-md-5">
          <div class="row align-items-start">
            <div class="col-md-2">
              <ul class="custom-menu">
               
                <li><a href="about.html">Bio</a></li>
                <li><a href="formu_db.php">Contacto</a></li>
              </ul>
            </div>
            
    
            <div class="col-md-6 d-none d-md-block  mr-auto">
              
            </div>
            <div class="col-md-4 d-none d-md-block">   
              <div class="col-sm-12 social text-md-end">
              <a href="http://twitter.com/vanityfer"><span class="bi bi-twitter"></span></a>
              <a href="https://www.facebook.com/fernanda.mugica/"><span class="bi bi-facebook"></span></a>
              <a href="https://www.instagram.com/vanity.fer/?hl=fr"><span class="bi bi-instagram"></span></a>
                      
            </div>
            </div>
    
    
          </div>
    
        </div>
      </div>
    
    
      <nav class="navbar navbar-light custom-navbar">
        <div class="container">
          <a class="navbar-brand" href="index.html"></a>
          <a href="#" class="burger" data-bs-toggle="collapse" data-bs-target="#main-navbar">
            <span></span>
          </a>
        </div>
      </nav>
    
      <main id="main">
    
        <section class="section pb-5">
          <div class="container">
            <div class="row mb-5 align-items-end">
              <div class="col-md-6" data-aos="fade-up">
    
                <h2><p id="titulo"></p></h2>
                
              </div>
    
            </div>
    
            <div class="row">
              
              <div class="col-md-4 ml-auto order-4" data-aos="fade-up">
                <br>
                <p><p id="descripcion"></p>
                Costo: <span id="costo"></span>
                <br>
                Duración: <span id= "duracion"></span> 
                <br>
                Cupo: <span id="cupo"></span>
                
                
               
                    
                
                

                
                    
                  
                </ul>
              </div>
    
              <div class="col-md-7 mb-5 mb-md-0" data-aos="fade-up">
                <p><iframe id="pantalla" width="600" height="450" src="">
                </iframe> 
                <p id="titulo"></p>
                </p>
                
              </div>
    
            </div>
    
          </div>
    
        </section>
    
      </main><!-- End #main -->
    
    
    
    
    </body>
    
  

 
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="vendor/aos/aos.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="vendor/php-email-form/validate.js"></script>
  <script src="vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Template Main JS File -->
  <script src="js/main.js"></script>
  <script src="js/hola.js"></script>

</body>

</html>