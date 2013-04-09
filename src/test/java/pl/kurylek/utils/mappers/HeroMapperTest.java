package pl.kurylek.utils.mappers;

import static org.fest.assertions.Assertions.assertThat;
import static pl.kurylek.utils.test.mocks.hero.HeroProfiledBuilder.aCaptainAmerica;

import org.junit.Test;

import pl.kurylek.utils.test.mocks.hero.Hero;
import pl.kurylek.utils.test.mocks.hero.HeroSnapshot;

public class HeroMapperTest {

    private final Mapper<Hero, HeroSnapshot> heroMapper = new Mapper<Hero, HeroSnapshot>() {

	@Override
	protected MappingStrategy<Hero, HeroSnapshot> getMappingStrategy() {
	    return new MappingStrategy<Hero, HeroSnapshot>() {

		@Override
		public HeroSnapshot map(Hero source) {
		    HeroSnapshot target = new HeroSnapshot();
		    target.setId(source.getId());
		    target.setName(source.getFirstName() + " " + source.getLastName());
		    return target;
		}

		@Override
		public Hero mapReversely(HeroSnapshot target) {
		    Hero source = new Hero();
		    source.setId(target.getId());
		    source.setFirstName(target.getName().split(" ")[0]);
		    source.setLastName(target.getName().split(" ")[1]);
		    return source;
		}
	    };
	}
    };

    @Test
    public void shouldMapHeroToHeroSnapshot() {
	// given
	Hero captainAmerica = aCaptainAmerica().build();

	// when
	HeroSnapshot result = heroMapper.map(captainAmerica);

	// then
	assertThat(result.getId()).isEqualTo(captainAmerica.getId());
	assertThat(result.getName()).isEqualTo(
		captainAmerica.getFirstName() + " " + captainAmerica.getLastName());
    }

    @Test
    public void shouldMapHeroSnaphotToHero() {
	// given
	HeroSnapshot heroSnapshot = new HeroSnapshot();
	heroSnapshot.setId(2L);
	heroSnapshot.setName("Johann Schmidt");

	// when
	Hero result = heroMapper.mapReversely(heroSnapshot);

	// then
	assertThat(result.getId()).isEqualTo(heroSnapshot.getId());
	assertThat(result.getFirstName() + " " + result.getLastName()).isEqualTo(heroSnapshot.getName());
    }
}