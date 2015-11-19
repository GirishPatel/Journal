# DSL for Journal

## Requirements
1. Tags support.
2. Can consider different kind of tasks
  1. Period - Start & End of task
  2. Just a note
  3. Overlapping task
3. Analysis:
  1. Can calculate context switching percentile
  2. Graphs based on tags
  3. Time spent in tasks
4. Reminders support
5. Structures to ease analysis
6. Views support:
  1. To show filtered list - all, done, pending etc.
  2. Multi-tab support to segregate similar type of journal - reminders, tasks etc.

## DSL Rules
1. Continue line -
2. Bullet line *,1,2,3
3. Add commands to do operations. e.g. delete previous line etc
4. Add index using colon :. e.g. tag:journal, importance:5, type:reminder

## Supported Types

### Events
 with/without period info (start, complete etc)
 
### Ideas, thoughts

### Reminders

### Tasks

#### Properties
1. Importance
2. Urgent
3. Significant

## Commands
### Properties of commands
1. Should be simple, i.e. negligible learing curve
2. Should be intuitive.
3. Commands will case insensitive
4. Follow simple english rules:
  1. present simple verb represent action
  2. present continues verb represent start of action
  3. present perfect verb represent end of action
### Supported commands
1. **exit**: Exit application
2. **start**:
