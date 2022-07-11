# AmeliaFishing
 
## About
AmeliaFishing is a basic fishing plugin to allow your players to gain rewards while fishing! You can set the chances on rewards, as well as make it so players need a specific permissions to obtain fishing rewards!

## Methods
```java
    public void onFish(final CustomFishEvent event) {
       event.getReward() // Gets the caught reward!
       event.setCancelled() // Allows you to cancel the capture event!
    }
```

```java
AmeliaFishing.PLUGIN.getRewardManager() // Allows access to manage rewards and generate your own FishingReward!
```
