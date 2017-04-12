package orly.logic;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Serj on 09.04.2017.
 */
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
    public RiderProfile getById(Integer id) {
        return entityManager.find(RiderProfile.class, id);
    }
    public List<RiderProfile> getByName(String name) {
        return entityManager.createQuery("from RiderProfile name = :name").setParameter("name", name).getResultList();
    }
    public List<RiderProfile> getByNickname(String nickname) {
        return entityManager.createQuery("from RiderProfile nickname = :nickname").setParameter("nickname", nickname).getResultList();
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
