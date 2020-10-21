package com.example.catalogoastronomico;

import org.apache.tools.ant.types.selectors.SelectSelector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import sun.rmi.runtime.Log;

/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */
public class CatalogoAstronomico {
    static ArrayList<Astro> catalogo;
    static int numEstrellasSimpleVista;
    static HashSet galaxias;


    public CatalogoAstronomico()
    {
        this.numEstrellasSimpleVista=0;
        this.galaxias= new HashSet();
        this.catalogo = new ArrayList<Astro>();

    }

    public ArrayList getCatalogo() {
        return catalogo;
    }

    public HashSet getGalaxias() {
        return galaxias;
    }

    public int getNumEstrellasSimpleVista() {
        return numEstrellasSimpleVista;
    }

    public boolean esEstrellaASimpleVista(int i)
    {
        numEstrellasSimpleVista=0;
        Astro estrellaAMirar = this.catalogo.get(i);
        if( estrellaAMirar instanceof Estrella && estrellaAMirar.visibleCon()== "a simple vista" )
        {
            numEstrellasSimpleVista++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean anade(Astro a1)
    {
        for (Astro a: catalogo)
        {
            if (a.getNombre().equals(a1.getNombre()))
            {
                return false;
            }
        }

        if (a1 instanceof Estrella)
        {
            catalogo.add(a1);
            catalogo.add(((Estrella)a1).getGalaxia());
            galaxias.add(((Estrella)a1).getGalaxia().getNombre());
        }
        else if (a1 instanceof Planeta)
        {
            catalogo.add(a1);
            catalogo.add(((Planeta)a1).getEstrella());
            catalogo.add(((Planeta)a1).getEstrella().getGalaxia());
            galaxias.add(((Planeta)a1).getEstrella().getGalaxia().getNombre());
        }
        else if (a1 instanceof Galaxia)
        {
            catalogo.add(a1);
            galaxias.add(((Galaxia)a1).getNombre());
        }


        return true;


    }

    public void borrar(String nombre)
    {
        for(Astro a: catalogo)
        {
            if(a.getNombre().equals(nombre))
            {
                this.catalogo.remove(a);
            }
        }
    }

    public Astro buscaAstro(String nombreAstro)
    {

        Astro res = null;
        for (Astro a: catalogo)
        {
            if (a.getNombre().equals(nombreAstro))
            {
                res = a;

            }
        }
        return res;
    }

    public Astro primeroMasBrillanteQue(Astro a1)
    {
        Astro res = null;

        for (Astro a: catalogo) {

            if (a1.getBrillo() < a.getBrillo())
            {
                res = a;
                break;
            }
        }


        return res;
    }

    public List<Astro> filtraEstrellasSimpleVista()
    {
        List<Astro> listaAstrosASimpleVista = new ArrayList<Astro>();
        for(int i=0; i<catalogo.size(); i++)
        {
            if (catalogo.get(i) instanceof Estrella)
            {
                if (esEstrellaASimpleVista(i))
                {
                    listaAstrosASimpleVista.add(catalogo.get(i));
                }
            }
        }
        return listaAstrosASimpleVista;
    }

    public Astro brillaMas()
    {
        Astro masBrillante = catalogo.get(0);
        for (Astro a: catalogo)
        {
            if (masBrillante.brillo < a.brillo)
            {
                masBrillante = a;
            }
        }
        return masBrillante;
    }

    public String toString()
    {
        String msg = "";
        for(Astro a:catalogo)
        {
            msg=msg + a.toString() +"\n";
        }
        return msg;
    }

}