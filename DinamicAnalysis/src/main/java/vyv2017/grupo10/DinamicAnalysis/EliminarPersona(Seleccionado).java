public boolean eliminarPersona (String nombre)
		{
			return elim (nombre,agenda);
		}
		private boolean elim (String nom, Agenda2 agen)
		{
			NodoAgenda ant = agen.cab;
			NodoAgenda act = ant.sig;
		    if (agen.cab != agen.cent) 
		    {
		      while (act.info.nombre!=nombre)
		      {
		    	  act=act.sig;
		    	  ant=ant.sig;
		      }
		      act=act.sig;
		      ant.sig=act;
		      return true;
		    }
		    else return false;
		}