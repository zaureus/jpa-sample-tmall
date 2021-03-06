package yang.yu.tmall.repository.spring.buyers;

import yang.yu.tmall.domain.buyers.ImType;
import yang.yu.tmall.domain.buyers.PersonalBuyer;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * 买家仓储特殊接口实现
 */
public class BuyerQueryOperationsImpl implements BuyerQueryOperations {

    private final EntityManager entityManager;

    public BuyerQueryOperationsImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Optional<PersonalBuyer> findPersonalBuyerByQQ(String qq) {
        String jpql = "select o from PersonalBuyer o join o.imInfos i where KEY(i) = :key and VALUE(i) = :value";
        return entityManager.createQuery(jpql, PersonalBuyer.class)
                .setParameter("key", ImType.QQ)
                .setParameter("value", qq)
                .getResultStream()
                .findAny();
    }
}
