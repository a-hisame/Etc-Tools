param($r)
# input = 03のようにすること
$i = 1
cat "round$r.txt" | `
 %{ scala PlayedFieldMaker ("round{0:00}\round{0:00}_{1:00}.png" -f $r, $i) `
    ($_) ("round{0:00}\round{0:00}_{1:00}.png" -f $r, ($i+1)); $i++ `
 }
