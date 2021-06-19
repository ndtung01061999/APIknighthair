package booking.converter;

import booking.dto.AccountDTO;
import booking.entity.Account;

public class AccountConverter {
	public void mappingDTOtoEntity(AccountDTO accountdto, Account account) {
		account.setName(accountdto.getName());
		account.setPassword(accountdto.getPassword());
		account.setType(accountdto.getType());
	}
	public void mappingEntitytoDTO(AccountDTO accountdto, Account account) {
		accountdto.setId(account.getId());
		accountdto.setName(account.getName());
		accountdto.setPassword(account.getPassword());
		accountdto.setType(account.getType());
	}
}
