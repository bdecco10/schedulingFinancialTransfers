package bdecco.cvc.financialscheduling.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.dao.SchendulingTransferDao;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;
import bdecco.cvc.financialscheduling.util.Validate;
public class SchendulingTrasnferController extends Validate implements Serializable {
	private static final long serialVersionUID = -1008629764974608075L;

	private SchendulingTransferDao dao = new SchendulingTransferDao();
	
	public void calculatesSchedulingTransfer(SchendulingTransferTO entity) throws OSSBusinessException {

		if(transferValueMoreThousand(entity)){
			if(transferDay(entity)){
				//Regra: Tranferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido
				entity.setRate(String.valueOf(transferToday(entity)));

			}
		}else if(transferValueTwoThousand(entity)){
			if(validateTransferUpToDays(entity)){
				//Regra: Tranferências até 10 dias da data de agendamento possuem uma taxa de $12
				entity.setRate(String.valueOf(transferUpToDays(entity)));

			}
		}else if (transferValueMoreTwoThousand(entity)) {
			if(validateTackwardAX(entity)){
				//Regra: Operações do tipo C tem uma taxa regressiva conforme a data de transferência:
				entity.setRate(String.valueOf(tackwardAX(entity)));
			}

		}
		
		if(null == entity.getRate()){
			throw new OSSBusinessException("Não existe TAXA aplicavel", "ERROR-CVC-001", "taxa nao se aplica");
		}
		
		addSchendulingTranfer(entity);
	}
	
	private void addSchendulingTranfer(SchendulingTransferTO entity){
		dao.addSchendulingTransfer(entity);
		
	}
	public SchendulingTransferTO  findSchendulingTranfer(String sourceCode) throws OSSBusinessException{
		
		return dao.findSchendulingTransfer(sourceCode);
	}

	public void  findSchendulingTranferFile(SchendulingTransferTO entity) throws OSSBusinessException, IOException{
		
		dao.findSchendulingTransferFile(entity);
	}
	public List<SchendulingTransferTO> findAllSchendulingTranfer() throws OSSBusinessException{
		
		return dao.findAllSchendulingTransfer();
	}
	
}
