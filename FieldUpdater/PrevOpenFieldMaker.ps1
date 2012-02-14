param($r)
# input: $r = 03のようにすること

# 裏カード位置決定
if( ([int]$r) -le 7 ) { $revcard = ("revcard\2_{0:00}.png" -f ($r-1)) }
else { $revcard = ("revcard\3_{0:00}.png" -f ($r - 8)) }

# 書き込み
scala PlayedFieldMaker ("round{0:00}\round{0:00}_01.png" -f $r) `
  $revcard ("round{0:00}\round{0:00}_00.png" -f $r)

