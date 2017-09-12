package bdecco.cvc.financialscheduling.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tlf.oss.common.exception.OSSBusinessException;

import bdecco.cvc.financialscheduling.entity.TransferEntity;
import bdecco.cvc.financialscheduling.to.SchendulingTransferTO;

@Mapper
public interface SchendulingTransferMapper {
	
	@Mapping(target="sourceAccount", source="schendulingTransferTO.sourceAccount")
	public TransferEntity getSchendulingTrasnferMapper(SchendulingTransferTO schendulingTransferTO)throws OSSBusinessException;

}
