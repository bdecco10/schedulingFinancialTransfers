package bdecco.cvc.financialscheduling.api;

import java.io.IOException;
import java.io.Serializable;
import java.time.Period;
import java.util.Optional;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.core.SchendulingTrasnferController;
import bdecco.cvc.financialscheduling.entity.TransferEntity;
import bdecco.cvc.financialscheduling.enums.Code;
import bdecco.cvc.financialscheduling.enums.Message;
import bdecco.cvc.financialscheduling.mapper.impl.SchendulingTransferResourceMapper;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;

public class SchedulingFinancial implements Serializable {
	private static final long serialVersionUID = -1008629764974608075L;

	public SchendulingTrasnferController controller = new SchendulingTrasnferController();

	private SchendulingTransferResourceMapper mapper = new SchendulingTransferResourceMapper();
	/**
	 * Chama a classe controller 
	 * reponsavel pela regra de negocio (calcular taxa)
	 */
	public void schedulingTrasnfer(SchendulingTransferTO SchendulingTransferTO) throws OSSBusinessException {
		//validação basica para nao ocorrer nullpointer
		validate(SchendulingTransferTO);

		//Calcula a taxa
		controller.calculatesSchedulingTransfer(SchendulingTransferTO);

	}
	/**
	 * Chama a classe controller 
	 * reponsavel pela regra de negocio (buscar cadastro por nome de conta)
	 */

	public TransferEntity findSchedulingTrasnfer(String souceCode) throws OSSBusinessException {
		//Mapper usado para facilitar o mapeamento de interface
		//E ajuda a limpar o codigo deixando mais simples
		SchendulingTransferTO find = controller.findSchendulingTranfer(souceCode);
		TransferEntity transferEntity = mapper.parseGetPhysicalReserveResource(find);

		return transferEntity;
	}

	/**
	 * Metodo reponsavel por recuperar do arquivo e exibir na tela
	 * @param entity
	 * @throws OSSBusinessException
	 * @throws IOException 
	 */
	public void findSchedulingTrasnferFile(SchendulingTransferTO find) throws OSSBusinessException, IOException {
		//Mapper usado para facilitar o mapeamento de interface
		//E ajuda a limpar o codigo deixando mais simples
		controller.findSchendulingTranferFile(find);
	}

	/**
	 * Metodo reponsavel por realizar validações basica para funcionar o processo
	 * @param entity
	 * @throws OSSBusinessException
	 */
	public void validate(SchendulingTransferTO entity) throws OSSBusinessException{
		Optional<SchendulingTransferTO> schendulingTO = Optional.ofNullable(entity);

		if(!schendulingTO.isPresent())
			throw new OSSBusinessException(Message.ERRO_VALIDATE_OBJECT.getValue(), Code.SCHENDULING_001.getValue(), Message.ERRO_VALIDATE_FILD.getValue() +" eh nulo");

		if(!schendulingTO.map(SchendulingTransferTO::getValueTransfer).isPresent())
			throw new OSSBusinessException(Message.ERRO_VALIDATE_OBJECT.getValue(), Code.SCHENDULING_001.getValue(), Message.ERRO_VALIDATE_FILD.getValue() +" getValueTransfer eh nulo");

		if(!schendulingTO.map(SchendulingTransferTO::getDateTransfer).isPresent())
			throw new OSSBusinessException(Message.ERRO_VALIDATE_OBJECT.getValue(), Code.SCHENDULING_001.getValue(), Message.ERRO_VALIDATE_FILD.getValue() +" getDateTransfer eh nulo");

		Period period = Period.between(entity.getDateAppointment(), entity.getDateTransfer());
		if(period.isNegative())
			throw new OSSBusinessException(Message.ERRO_VALIDATE_OBJECT.getValue(), Code.SCHENDULING_001.getValue(), Message.ERRO_VALIDATE_FILD.getValue() +" getDateTransfer eh menor que o getDateAppointment");
	}
	public SchendulingTrasnferController getController() {
		return controller;
	}
	public void setController(SchendulingTrasnferController controller) {
		this.controller = controller;
	}


}
