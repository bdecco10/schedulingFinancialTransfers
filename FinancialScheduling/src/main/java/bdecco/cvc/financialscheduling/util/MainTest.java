package bdecco.cvc.financialscheduling.util;

import java.io.IOException;
import java.time.LocalDate;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.api.SchedulingFinancial;
import bdecco.cvc.financialscheduling.entity.TransferEntity;
import bdecco.cvc.financialscheduling.enums.Code;
import bdecco.cvc.financialscheduling.enums.Message;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;

public class MainTest {

	public static void main(String[] args) throws Exception {

		try{
			ResourceFile resourceFile = new ResourceFile();

			String[] dateScgenduling = args[0].split("/");
			String valueTrasnfer = args[1];
			String destinationCount = args[2];
			String operation = args[3];
			
			SchedulingFinancial schedulingFinancial = new SchedulingFinancial();
			SchendulingTransferTO schendulingTransferTO = new SchendulingTransferTO();

			LocalDate today = LocalDate.now();
			LocalDate schedule = LocalDate.of(Integer.valueOf(dateScgenduling[2]), Integer.valueOf(dateScgenduling[1]), Integer.valueOf(dateScgenduling[0]));

			schendulingTransferTO.setDateAppointment(today);
			schendulingTransferTO.setDateTransfer(schedule);
			schendulingTransferTO.setDestinationAccount(destinationCount);
			schendulingTransferTO.setSourceAccount("XXXXXX");
			schendulingTransferTO.setValueTransfer(Integer.valueOf(valueTrasnfer));

			if("ADD".equals(operation.toUpperCase())){

				//Calcula taxa
				schedulingFinancial.schedulingTrasnfer(schendulingTransferTO);

				//Busca Taxa
				TransferEntity transferEntity =	schedulingFinancial.findSchedulingTrasnfer(schendulingTransferTO.getSourceAccount());

				resourceFile.writeFiles(transferEntity);

				System.out.println("Operação adicionada com sucesso");
				
			}else if("FIND".equals(operation.toUpperCase())){

				//Busca Taxa de arquivo
				schedulingFinancial.findSchedulingTrasnferFile(schendulingTransferTO);

			}else{
				throw new OSSBusinessException(Message.ERRO_VALIDATE_OPERATION.getValue(), Code.SCHENDULING_004.getValue(), Message.ERRO_VALIDATE_OPERATION_NOT_FOUND.getValue());
			}
		}
		catch (OSSBusinessException  e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
			throw new OSSBusinessException(Message.ERRO_VALIDATE_FILE_NOT_FOUND.getValue(), Code.SCHENDULING_005.getValue(), e.getMessage());
		}catch (Exception e) {
			System.out.println(e);
			throw new OSSBusinessException(Message.ERRO_VALIDATE_PARAMETERES_NOT_FOUND.getValue(), Code.SCHENDULING_003.getValue(), Message.ERRO_VALIDATE_INFORMATION.getValue());
		}
	}
}
