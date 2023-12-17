package Services;
import Models.Corrida;
import Models.Piloto;
import java.util.ArrayList;
import java.util.List;
import com.grupocriar.corrida.FileReader;


public class CorridaService {
	
	public List<Corrida> TotalVoltasPorPiloto = new ArrayList<>();
	List<Piloto> listaPiloto = FileReader.LerCorridaTxt();
	
	
	
}
