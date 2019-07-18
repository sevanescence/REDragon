# REDragon
RE:Dragon allows ender dragon eggs to drop from all ender dragon deaths after the first ender dragon.

config.yml
```yml
#######################
# RE: DRAGON v1.0.0   #
#######################
# configuration file  #
#######################

# leave this empty, or write "null", to disable
egg-drop-message: "&8[&dRE:Dragon&8] &7The dragon egg has dropped at &b%drop-location%&7!"

# this is what the coordinates will look like
drop-location-format: "&bX:%x%&7, &bY:%y%&7, &bZ:%z%"

# set this to true if the first dragon on your
# server is already dead. if false, the plugin
# will check if there are end portals
# already in the end portal frame, then set it
# to true. This is to avoid a bug where the
# dragon egg will drop twice when the first
# ender dragon dies.
default-dragon-dead: false
```

# Changelog
### 1.0
```diff
RE:Dragon released.
+ Dragon Eggs are placed beneath ender dragons upon death.
+ Configurable egg drop message with drop location placeholder.
+ Configurable drop location placeholder format with x, y, and z coordinates.
```
### 1.1
```diff
Dragpm Egg Drop - Location Change
+ Dragon eggs are placed on at the top of end exit portals if one isn't already present.
+ Bug patched where dragon egg will drop twice from first ender dragon.
+ default-dragon-dead setting added to config.
  set this to true if the first ender dragon on your server is already dead.
  if it remains false, it will be set to true if there are end portals in
  the end.
```

# todo
- [ ] check if ender dragon death is the first by checking if the egg has spawned along 0 y 0
- [ ] check if the last block is a non-solid block i.e. water, lava, rather than just air
- [ ] add world placeholder
- [ ] play sound effect when egg is dropped
