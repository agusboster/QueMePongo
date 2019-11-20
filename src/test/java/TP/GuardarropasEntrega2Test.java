package TP;
import TP.User.Usuario;
import TP.User.UsuarioDTO;
import TP.repos.RepositorioCategoria;
import TP.repos.RepositorioEvento;
import TP.repos.RepositorioGuardarropas;
import TP.repos.RepositorioUsuario;
import TP.repos.factories.FactoryRepositorioCategoria;
import TP.repos.factories.FactoryRepositorioEvento;
import TP.repos.factories.FactoryRepositorioGuardarropas;
import TP.repos.factories.FactoryRepositorioUsuario;
import db.EntityManagerHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.persistence.TypedQuery;
import java.awt.image.BufferedImage;
import java.util.*;

import static db.EntityManagerHelper.createQuery;

public class GuardarropasEntrega2Test {

    Usuario user;
    UsuarioDTO userDto;

    Prenda remera;
    Prenda buzo;
    Prenda campera;
    Prenda pullover;
    Prenda pantalon;
    Prenda zapatillas;
    Prenda gorroDeLana;
    Prenda anteojosDeSol;
    Prenda sandalias;
    Prenda crocs;
    Prenda musculosa;
    Prenda remeraMangaLarga;
    Evento unEvento;
    atuendoNivelAltoCommand commandAlto;
    SugeridorDeAtuendos unSugeridor;
    Guardarropas unGuardarropas;
    ArrayList<Guardarropas> listaGuardarropas;
    ArrayList<Prenda> prendas;

    Categoria superior;
    Categoria inferior;
    Categoria calzado;
    Categoria accesorios;


    Capa superior0;
    Capa superior1;
    Capa superior2;
    Capa inferior1;
    Capa calzado0;
    Capa accesorios1;
    Capa accesorios2;

    ArrayList<Capa> capasSuperiores;
    ArrayList<Capa> capasInferiores;
    ArrayList<Capa> capasCalzado;
    ArrayList<Capa> capasAccesorios;

    Sensibilidad sensibilidadSuperior;
    Sensibilidad sensibilidadInferior;
    Sensibilidad sensibilidadCalzado;
    Sensibilidad sensibilidadAccesorios;
    List<Sensibilidad> listaMedidores;

    BufferedImage unaImagenDePrueba;

//2019quemepongo
    Sensibilidad unMedidor;

    @BeforeEach
    public void fixture() {

/*
        try {
            unaImagenDePrueba = ImageIO.read(Resources.class.getResource("D:\\Pablo\\UTN\\utn 2019\\DDS\\repo tp\\2019-mi-no-group-02\\Documentacion\\imagenTest.jpg"));
        }catch (IOException ex){
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);        }
*/


        prendas = new ArrayList<Prenda>() {{
            add(remera);
            add(musculosa);
            add(remeraMangaLarga);
            add(buzo);
            add(campera);
            add(pullover);
            add(pantalon);
            add(zapatillas);
            add(sandalias);
            add(crocs);
        }};

    }

    @Test
    public void usuarioPideSugerencia() {
/*
       try {

            unSugeridor = SugeridorDeAtuendos.get();
            commandAlto = new atuendoNivelAltoCommand(unSugeridor);

           String telefonoCualca = "12345";
            userDto = new UsuarioDTO("pablooib81@gmail.com", telefonoCualca);
            user = new Usuario(userDto);

           unEvento = new Evento("lollapalooza", 3,new Frecuencia(false,0));
           unEvento.getUsuarios().add(user);

           unGuardarropas = new Guardarropas(unSugeridor, commandAlto, "ropero");

           superior0 = new Capa(0, 2.5);
           superior1 = new Capa(1, 3.0);
           superior2 = new Capa( 2, 3.5);
           inferior1 = new Capa(1, 3.0);
           calzado0 = new Capa(0, 0.0);
           accesorios1 = new Capa( 1, 5.0);
           accesorios2 = new Capa( 0, 7.0);

           superior = new Categoria ("superior");
           inferior = new Categoria ("inferior");
           calzado = new Categoria ("calzado");
           accesorios = new Categoria ("accesorios");

           superior.getCapas().add(superior0);
           superior.getCapas().add(superior1);
           superior.getCapas().add(superior2);
           inferior.getCapas().add(inferior1);
           calzado.getCapas().add(calzado0);
           accesorios.getCapas().add(accesorios1);
           accesorios.getCapas().add(accesorios2);

           remera = new Prenda("Remera ",null, "tela", superior, superior0, unGuardarropas);
           musculosa = new Prenda("Musculosa",null, "tela", superior, superior0, unGuardarropas);
           remeraMangaLarga = new Prenda("Remera manga larga",null, "tela", superior, superior0, unGuardarropas);
           buzo = new Prenda("Buzo", null, "tela", superior, superior1, unGuardarropas);
           pullover = new Prenda("Pullover", null, "tela", superior,superior1, unGuardarropas);
           campera = new Prenda("Campera", null, "tela", superior, superior2, unGuardarropas) ;
           pantalon = new Prenda("Pantalon", null, "tela", inferior, inferior1, unGuardarropas);
           zapatillas = new Prenda("Zapatillas", null, "tela", calzado, calzado0, unGuardarropas);
           sandalias = new Prenda("Sandalias", null, "tela", calzado,calzado0, unGuardarropas);
           crocs = new Prenda("Crocs", null, "tela", calzado,calzado0, unGuardarropas);
           gorroDeLana = new Prenda("Gorro de lana", null, "tela", accesorios,accesorios2, unGuardarropas);
           anteojosDeSol = new Prenda("anteojos de sol", null, "tela", accesorios,accesorios1, unGuardarropas);


           unGuardarropas.getPrendas().add(remera);
           unGuardarropas.getPrendas().add(musculosa);
           unGuardarropas.getPrendas().add(remeraMangaLarga);
           unGuardarropas.getPrendas().add(buzo);
           unGuardarropas.getPrendas().add(campera);
           unGuardarropas.getPrendas().add(pullover);
           unGuardarropas.getPrendas().add(pantalon);
           unGuardarropas.getPrendas().add(zapatillas);
           unGuardarropas.getPrendas().add(sandalias);
           unGuardarropas.getPrendas().add(crocs);

           user.listaGuardarropas().add(unGuardarropas);

           sensibilidadSuperior = new Sensibilidad(superior, 0, userDto, "superior");
           sensibilidadInferior = new Sensibilidad(inferior, 0, userDto, "inferior");
           sensibilidadCalzado = new Sensibilidad(calzado, 0, userDto, "calzado");
           sensibilidadAccesorios = new Sensibilidad(accesorios, 0, userDto, "accesorio");

           userDto.getMedidores().add(sensibilidadSuperior);
           userDto.getMedidores().add(sensibilidadInferior);
           userDto.getMedidores().add(sensibilidadCalzado);
           userDto.getMedidores().add(sensibilidadAccesorios);

            Atuendo atuendo = user.pedirSugerencia(unGuardarropas, unEvento, unSugeridor);
            System.out.println(atuendo);

        } catch (Exception e) {
            System.out.println("Error: No fue valido el atuendo.");
    }
*/
    }

    @Test
    public void persistir1EventoTest(){

        EntityManagerHelper.beginTransaction();

        String telefonoCualca = "12345";
        userDto = new UsuarioDTO("pablooib81@gmail.com", telefonoCualca, "pabli", "1234");
        user = new Usuario(userDto);

        EntityManagerHelper.getEntityManager().persist(user);

        unEvento = new Evento("lollapalooza", 3,new Frecuencia(false,0));
        //unEvento.getUsuarios().add(user);

        EntityManagerHelper.getEntityManager().persist(unEvento);
        EntityManagerHelper.commit();

    }

    @Test
    public void persistir1PrendaTest(){

        SugeridorDeAtuendos unSugeridor = SugeridorDeAtuendos.get();

        RepositorioEvento repoEvento = FactoryRepositorioEvento.get();
        Evento evento = repoEvento.buscar(1);

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(1);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(1);

        Atuendo unAtuendo = unSugeridor.sugerirAtuendo(evento, guardarropas.getPrendas(), user);

        List<Prenda> prendas = unAtuendo.getPrendas();

        for (Prenda prenda : prendas){
            System.out.println(" " + prenda.getDescripcion());
        }

    }

    @Test
    public void persistirGeneracionDeAtuendo(){

        //https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/

       try {
            unSugeridor = SugeridorDeAtuendos.get();
            commandAlto = new atuendoNivelAltoCommand(unSugeridor);

            String telefonoCualca = "12345";

            EntityManagerHelper.beginTransaction();

            userDto = new UsuarioDTO("pablooib81@gmail.com",telefonoCualca, "pablo", "1234");

            EntityManagerHelper.getEntityManager().persist(userDto);

            user = new Usuario(userDto);

            EntityManagerHelper.getEntityManager().persist(user);

            unGuardarropas = new Guardarropas(unSugeridor, commandAlto, "ropero");

            EntityManagerHelper.getEntityManager().persist(unGuardarropas);

            GuardarropasXUsuario nuevoGuardarropasXUsuario = new GuardarropasXUsuario(unGuardarropas, userDto);

            EntityManagerHelper.getEntityManager().persist(nuevoGuardarropasXUsuario);


            unEvento = new Evento("lollapalooza", 3,new Frecuencia(false,0));
//            unEvento.getUsuarios().add(user);

            EntityManagerHelper.getEntityManager().persist(unEvento);

            EventoXUsuario eventoUsuario = new EventoXUsuario(unEvento, userDto);
            EntityManagerHelper.getEntityManager().persist(eventoUsuario);


          //  user.listaGuardarropas().add(unGuardarropas);

            superior = new Categoria ("superior");
            inferior = new Categoria ("inferior");
            calzado = new Categoria ("calzado");
            accesorios = new Categoria ("accesorios");

            EntityManagerHelper.getEntityManager().persist(superior);
            EntityManagerHelper.getEntityManager().persist(inferior);
            EntityManagerHelper.getEntityManager().persist(calzado);
            EntityManagerHelper.getEntityManager().persist(accesorios);

            superior0 = new Capa(0, 3.5, superior);
            superior1 = new Capa(1, 4.0, superior);
            superior2 = new Capa( 2, 4.5, superior);
            inferior1 = new Capa(1, 4.0, inferior);
            calzado0 = new Capa(0, 0.0, calzado);
            accesorios1 = new Capa( 1, 5.0, accesorios);
            accesorios2 = new Capa( 0, 7.0, accesorios);

            EntityManagerHelper.getEntityManager().persist(superior0);
            EntityManagerHelper.getEntityManager().persist(superior1);
            EntityManagerHelper.getEntityManager().persist(superior2);
            EntityManagerHelper.getEntityManager().persist(inferior1);
            EntityManagerHelper.getEntityManager().persist(calzado0);
            EntityManagerHelper.getEntityManager().persist(accesorios1);
            EntityManagerHelper.getEntityManager().persist(accesorios2);


            remera = new Prenda("Remera ",null, "tela", "superior", 0, 2.5, unGuardarropas);
            musculosa = new Prenda("Musculosa",null, "tela", "superior", 0, 2.5, unGuardarropas);
            remeraMangaLarga = new Prenda("Remera manga larga",null, "tela", "superior", 0, 2.5,  unGuardarropas);
            buzo = new Prenda("Buzo", null, "tela", "superior", 1, 3.0, unGuardarropas);
            Prenda buzito = new Prenda("Buzito", null, "tela", "superior",1, 2.0, unGuardarropas);
            pullover = new Prenda("Pullover", null, "tela", "superior",1, 3.0, unGuardarropas);
            Prenda camperaAbrigada = new Prenda("Camperon", null, "tela", "superior", 2, 2.0, unGuardarropas) ;
            campera = new Prenda("Campera", null, "tela", "superior", 2, 2.5, unGuardarropas) ;
            pantalon = new Prenda("Pantalon", null, "tela", "inferior", 1, 3.0, unGuardarropas);
            zapatillas = new Prenda("Zapatillas", null, "tela", "calzado", 0, 0.0, unGuardarropas);
            sandalias = new Prenda("Sandalias", null, "tela", "calzado",0, 0.0, unGuardarropas);
            crocs = new Prenda("Crocs", null, "tela", "calzado",0, 0.0, unGuardarropas);
            gorroDeLana = new Prenda("Gorro de lana", null, "tela", "accesorios",2, 5.0, unGuardarropas);
            anteojosDeSol = new Prenda("anteojos de sol", null, "tela", "accesorios",1, 7.0,unGuardarropas);

            EntityManagerHelper.getEntityManager().persist(remera);
            EntityManagerHelper.getEntityManager().persist(musculosa);
            EntityManagerHelper.getEntityManager().persist(remeraMangaLarga);
            EntityManagerHelper.getEntityManager().persist(buzo);
            EntityManagerHelper.getEntityManager().persist(buzito);
            EntityManagerHelper.getEntityManager().persist(campera);
            EntityManagerHelper.getEntityManager().persist(camperaAbrigada);
            EntityManagerHelper.getEntityManager().persist(pullover);
            EntityManagerHelper.getEntityManager().persist(pantalon);
            EntityManagerHelper.getEntityManager().persist(zapatillas);
            EntityManagerHelper.getEntityManager().persist(sandalias);
            EntityManagerHelper.getEntityManager().persist(crocs);

        unGuardarropas.getPrendas().add(remera);
        unGuardarropas.getPrendas().add(musculosa);
        unGuardarropas.getPrendas().add(remeraMangaLarga);
        unGuardarropas.getPrendas().add(buzo);
        unGuardarropas.getPrendas().add(campera);
        unGuardarropas.getPrendas().add(pullover);
        unGuardarropas.getPrendas().add(pantalon);
        unGuardarropas.getPrendas().add(zapatillas);
        unGuardarropas.getPrendas().add(sandalias);
        unGuardarropas.getPrendas().add(crocs);

        sensibilidadSuperior = new Sensibilidad(superior, 0, userDto, "superior");
        sensibilidadInferior = new Sensibilidad(inferior, 0, userDto, "inferior");
        sensibilidadCalzado = new Sensibilidad(calzado, 0, userDto, "calzado");
        sensibilidadAccesorios = new Sensibilidad(accesorios, 0, userDto, "accesorio");

        EntityManagerHelper.getEntityManager().persist(sensibilidadCalzado);
        EntityManagerHelper.getEntityManager().persist(sensibilidadSuperior);
        EntityManagerHelper.getEntityManager().persist(sensibilidadInferior);
        EntityManagerHelper.getEntityManager().persist(sensibilidadAccesorios);

                 Atuendo atuendo = user.pedirSugerencia(unGuardarropas, unEvento, unSugeridor);
                 EntityManagerHelper.getEntityManager().persist(atuendo);
        EntityManagerHelper.commit();



        } catch (Exception e) {
            System.out.println("Error: No fue valido el atuendo.");
        }

    }


    @Test
    public void recuperarDeManíToManí() {

        List<Usuario> usuarios =  createQuery("from GuardarropasXUsuario").getResultList();
        for (Usuario unUsuario : usuarios) {
            System.out.println(" " + unUsuario.getIdUsuario());
        }
        }



    @Test
    public void testQueTeSalvaLasPapas() {

        Map<String, Object> parametros = new HashMap<>();
        RepositorioCategoria repoCategoria = FactoryRepositorioCategoria.get();
        List<Categoria> categorias = repoCategoria.buscarTodos();
        for (Categoria categoria : categorias){
            System.out.println(" " + categoria.getTipo());
        }
    }

    @Test
    public void vamoAVer2() {

        Guardarropas guardarropas = EntityManagerHelper.getEntityManager().find(Guardarropas.class, 1);
        List<Prenda> prendas = guardarropas.getPrendas();

        for (Prenda unaPrenda : prendas){
            System.out.println(" " + unaPrenda.getDescripcion());
        }

    }
    @Test
    public void vamoAVer(){
        List<Guardarropas> guardarropas = EntityManagerHelper.getEntityManager().createQuery("from Guardarropas").getResultList();
        for (Guardarropas unGuardarropas : guardarropas){
            System.out.println(" " + unGuardarropas.getDescripcion());
        }
    }

    @Test
    public void estaDifficult(){

      //  List<Prenda> prendas = EntityManagerHelper.getEntityManager().createQuery("from Prenda WHERE categoria = :desc").setParameter("desc", "superior").getResultList();

        TypedQuery<Prenda> query = (TypedQuery<Prenda>) EntityManagerHelper.getEntityManager().createQuery("from Prenda WHERE categoria = :cat AND capa = :cap AND (Nivel_de_abrigo < :num)" );
        query.setParameter("cat", "superior");
        query.setParameter("cap",0);
        query.setParameter("num",3.0);
        List<Prenda> prendasFiltradas = query.getResultList();


        Random rand = new Random();
        Prenda prendita = prendasFiltradas.get(rand.nextInt(prendasFiltradas.size()));

        if (prendasFiltradas.contains(prendita)) {
            System.out.println(" " + prendita.getDescripcion());
        }

    }

    @Test
    public void laGeneracionDeAtuendos() {
        SugeridorDeAtuendos unSugeridor = SugeridorDeAtuendos.get();

        RepositorioEvento repoEvento = FactoryRepositorioEvento.get();
        Evento evento = repoEvento.buscar(1);

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(1);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(1);

        Atuendo unAtuendo = unSugeridor.sugerirAtuendo(evento, guardarropas.getPrendas(), user);

        List<Prenda> prendas = unAtuendo.getPrendas();
        for (Prenda prenda : prendas){
            System.out.println(" " + prenda.getDescripcion());
        }
    }



@Test
        public void test1ToManyUsuarioMedidores(){
    UsuarioDTO elUserDto = (UsuarioDTO) createQuery("from UsuarioDTO where Numero_De_Telefono = 12345").getSingleResult();
    List<Sensibilidad> medidores = elUserDto.getMedidores();
        for (Sensibilidad medidor : medidores){
        System.out.println(" " + medidor.parte_del_cuerpo);
    }
}


}