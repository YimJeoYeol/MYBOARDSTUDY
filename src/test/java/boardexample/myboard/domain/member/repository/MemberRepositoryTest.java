package boardexample.myboard.domain.member.repository;

import boardexample.myboard.domain.member.Member;
import boardexample.myboard.domain.member.Role;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @AfterEach
    private void after(){
        em.clear();
    }

    public void 회원저장_성공() throws Exception{
        Member member = Member.builder().username("username").password("1234").nickName("Nick").role(Role.USER).age(22).build();

        Member saveMember = memberRepository.save(member);

        Member findeMember = memberRepository.findById(saveMember.getId()).orElseThrow(()-> new RuntimeException("저장된 회원이 없습니다."));     //아직 예외 클래스를 만들지 않았기에 RuntimeException으로 처리하겠습니다.


        assertThat(findeMember).isSameAs(saveMember);
        assertThat(findeMember).isSameAs(member);
    }

}
