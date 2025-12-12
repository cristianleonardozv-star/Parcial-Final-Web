package com.mundialscore.repository;

import com.mundialscore.entity.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {

    Optional<Prediction> findByUser_IdAndMatch_Id(Long userId, Long matchId);

    List<Prediction> findByUser_UsernameOrderByIdDesc(String username);

    List<Prediction> findByMatch_Id(Long matchId);

    interface LeaderboardProjection {
        String getUsername();
        Long getTotalPoints();
    }

    @Query("""
        select p.user.username as username, sum(p.points) as totalPoints
        from Prediction p
        group by p.user.username
        order by sum(p.points) desc, p.user.username asc
    """)
    List<LeaderboardProjection> leaderboard();
}
