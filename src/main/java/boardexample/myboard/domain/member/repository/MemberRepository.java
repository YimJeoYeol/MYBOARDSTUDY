package boardexample.myboard.domain.member.repository;

import boardexample.myboard.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserName(String username);

    boolean exitsByUsername(String username);
}