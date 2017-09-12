package bdecco.cvc.financialscheduling.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.enums.Code;
import bdecco.cvc.financialscheduling.enums.Message;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;
import bdecco.cvc.financialscheduling.util.ResourceFile;

public class SchendulingTransferDao {

	private Map<String, SchendulingTransferTO> mapSchendulingTrasnfer = new HashMap<String, SchendulingTransferTO>();
	private ResourceFile resourceFile = new ResourceFile();
	
	public void addSchendulingTransfer(SchendulingTransferTO schendulingTransferTO){
		mapSchendulingTrasnfer.put(schendulingTransferTO.getSourceAccount(), schendulingTransferTO);
	}

	public SchendulingTransferTO findSchendulingTransfer(String sourceCount) throws OSSBusinessException{
		SchendulingTransferTO schendulingTransferTO = null;
		
		if ( mapSchendulingTrasnfer.containsKey(sourceCount) ) {
			schendulingTransferTO = mapSchendulingTrasnfer.get(sourceCount);
		}
		
		if(null == schendulingTransferTO){
			throw new OSSBusinessException(Message.ERRO_VALIDATE_ISEMPTY.getValue() + sourceCount +" informada", Code.SCHENDULING_002.getValue(), Message.ERRO_VALIDATE_NOT_FOUND.getValue());
		}

		return schendulingTransferTO;
	}
	
	public void findSchendulingTransferFile(SchendulingTransferTO transferEntity) throws OSSBusinessException, IOException{
		
		File file = new File(transferEntity.getSourceAccount()+"_"+transferEntity.getDateAppointment()+".txt");
		resourceFile.readFiles(file);
		
	}


	public List<SchendulingTransferTO> findAllSchendulingTransfer() throws OSSBusinessException{
		
		List<SchendulingTransferTO> list = new ArrayList<>(); 
		for (String key : mapSchendulingTrasnfer.keySet()) {
			 
			 SchendulingTransferTO schendulingTransferTO = mapSchendulingTrasnfer.get(key);
			 list.add(schendulingTransferTO);
      }
		return list;
	}
}
