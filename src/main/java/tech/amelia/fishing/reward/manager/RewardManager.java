package tech.amelia.fishing.reward.manager;

import tech.amelia.fishing.config.Config;
import tech.amelia.fishing.reward.FishingReward;
import tech.amelia.fishing.utils.RandomList;

import java.util.ArrayList;
import java.util.List;

public final class RewardManager {

    private static final List<FishingReward> REWARDS = new ArrayList<>();
    private RandomList<FishingReward> randomList;

    public RewardManager() {
        this.loadRewards();
        this.loadRandom();
    }

    private void addReward(final String identifier) {
        RewardManager.REWARDS.add(new FishingReward(identifier));
    }

    private void loadRewards() {

        for (final String identifier : Config.SETTINGS.getConfig().getConfigurationSection("Rewards").getKeys(false)) {
            this.addReward(identifier);
        }

    }

    private void loadRandom() {

        this.randomList = new RandomList<>();

        for (final FishingReward reward : RewardManager.REWARDS) {
            this.randomList.add(reward, reward.getChance());
        }
    }

    public FishingReward pickReward() {
        return this.randomList.raffle();
    }
}
