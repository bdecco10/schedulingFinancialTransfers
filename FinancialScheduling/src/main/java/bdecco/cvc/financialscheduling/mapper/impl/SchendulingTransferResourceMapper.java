package bdecco.cvc.financialscheduling.mapper.impl;

import org.mapstruct.factory.Mappers;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.entity.TransferEntity;
import bdecco.cvc.financialscheduling.mapper.SchendulingTransferMapper;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;

public class SchendulingTransferResourceMapper{
	
	public TransferEntity parseGetPhysicalReserveResource(SchendulingTransferTO schendulingTransferTO) throws OSSBusinessException{

		SchendulingTransferMapper mapper = Mappers.getMapper(SchendulingTransferMapper.class);
		
		TransferEntity transferEntity = mapper.getSchendulingTrasnferMapper(schendulingTransferTO);

		return transferEntity;
	}

}
