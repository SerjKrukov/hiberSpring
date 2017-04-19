package orly.logic;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class RiderProfileDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void addRiderProfile(RiderProfile riderProfile) {
        entityManager.persist(riderProfile);
        return;
    }
    @SuppressWarnings("unchecked")
    public List<RiderProfile> getAllRiderProfiles() {
        return entityManager.createQuery("from RiderProfile").getResultList();
    }
    public RiderProfile getById(long id) {
        return entityManager.find(RiderProfile.class, id);
    }
    public RiderProfile getByName(String name) {
        return (RiderProfile) entityManager.createQuery("from RiderProfile name = :name").setParameter("name", name).getSingleResult();
    }
    public RiderProfile getByNickname(String nickname) {
        return (RiderProfile) entityManager.createQuery("from RiderProfile nickname = :nickname").setParameter("nickname", nickname).getSingleResult();
    }
    public void updateRiderProfile(RiderProfile riderProfile) {
        entityManager.merge(riderProfile);
        return;
    }
    public void removeRiderProfile(RiderProfile riderProfile) {
        if (entityManager.contains(riderProfile)) {
            entityManager.remove(riderProfile);
        } else {
            entityManager.remove(entityManager.merge(riderProfile));
        }
    }
}
