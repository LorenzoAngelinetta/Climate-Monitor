package climatemonitoring;

import Grafica.SceltaModalita;
import Grafica.AvvioServer;
import java.rmi.RemoteException;

/**
 * Progetto laboratorio B: "Climate Monitor", anno 2023-2024
 * @author Lorenzo Angelinetta
 * @version  2.0
 */
public class ClimateMonitor 
{
    /**
     * Qui viene lanciata l'applicazione
     * @param args argomenti main
     */
    public static void main(String[] args) throws RemoteException
    {  
        //AvvioServer.main(args);
        SceltaModalita.main(args);
    }
}
